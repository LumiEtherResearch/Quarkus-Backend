pipeline {
    agent any

    tools {
        maven 'Maven' // Replace with the name you gave to your maven tool in global tool configuration.
//         jdk 'Java' // Replace with the name you gave to your jdk tool in global tool configuration.
    }

    stages {
        stage('Verify Java and Maven') {
		    steps {
		        sh 'java -version'
		        sh 'mvn -version'
		        sh 'mvn compile'
		    }
		}

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests=true'
            }
        }

        stages {
        stage('Run JAR with Timeout') {
            steps {
                script {
                    def exitCode = sh(script: 'timeout 120 java -jar target/demo-1.0-SNAPSHOT-runner.jar', returnStatus: true)
                    if (exitCode == 124) {
                        echo "JAR process timed out as expected."
                    } else if (exitCode != 0) {
                        error "JAR process failed with exit code ${exitCode}"
                    } else {
                        echo "JAR process completed successfully before timeout."
                    }
                }
            }
        }

        stage('Stop') {
            steps {
                sh 'echo "Done! Successfully Executed!"' // Stop the Quarkus app
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
