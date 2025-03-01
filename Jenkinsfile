pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'http://192.168.0.20:31803/LumiEtherResearch/Quarkus-Backend.git' // Replace with your repository URL and branch
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run') {
            steps {
                sh 'java -jar target/*-SNAPSHOT.jar &' // Run in background (&)
                sleep 10 // Give Quarkus time to start
            }
        }

        stage('Test') {
            steps {
                sh 'curl http://localhost:8080/hello'
            }
        }

        stage('Stop') {
            steps {
                sh 'pkill -f "target/*-SNAPSHOT.jar"' // Stop the Quarkus app
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
