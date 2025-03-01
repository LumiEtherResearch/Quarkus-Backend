pipeline {
    agent any

    tools {
        maven 'Maven' // Replace with the name you gave to your maven tool in global tool configuration.
//         jdk 'Java' // Replace with the name you gave to your jdk tool in global tool configuration.
    }

    stages {
        stage('Build') {
            steps {
                sh 'java -version && mvn clean -DskipTests=true'
            }
        }

//         stage('Run') {
//             steps {
//                 sh 'java -jar target/*-SNAPSHOT.jar &' // Run in background (&)
//                 sleep 10 // Give Quarkus time to start
//             }
//         }
//
//         stage('Test') {
//             steps {
//                 sh 'curl http://localhost:8080/hello'
//             }
//         }
//
//         stage('Stop') {
//             steps {
//                 sh 'pkill -f "target/*-SNAPSHOT.jar"' // Stop the Quarkus app
//             }
//         }
    }

    post {
        always {
            cleanWs()
        }
    }
}
