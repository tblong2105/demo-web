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
                sh './mvnw clean install'
            }
        }

        stage('Deploy Backend') {
            steps {
                // Deploy backend (e.g., Docker or server script)
                sh 'docker build -t spring-boot-app .'
                sh 'docker run -d -p 8080:8080 spring-boot-app'
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
