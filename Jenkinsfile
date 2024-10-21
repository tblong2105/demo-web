pipeline {
    agent any

    stages {
        stage('Clone Backend Repository') {
            steps {
                git branch: 'master', url: 'https://github.com/tblong2105/demo-web.git'
            }
        }

        stage('Build Backend') {
            steps {
                // Build Spring Boot using Maven
                sh 'chmod +x mvnw'
                sh './mvnw clean install'
                sh './mvnw build'
            }
        }

    }

    post {
        success {
            echo 'Spring Boot build and deploy successful!'
        }
        failure {
            echo 'Spring Boot build failed!'
        }
    }
}

