pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials')  // Thông tin đăng nhập Docker Hub (hoặc registry khác)
        IMAGE_NAME = "tblong2105/something-server:latest"  // Tên của image trên Docker Hub
    }

    stages {
        stage('Build Maven Project') {
            steps {
                // Build ứng dụng Spring Boot bằng Maven
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Build Docker image từ Dockerfile
                script {
                    docker.build("${IMAGE_NAME}:${env.BUILD_ID}")
                }
            }
        }
        stage('Push Docker Image to Registry') {
            steps {
                // Đăng nhập vào Docker Hub và đẩy image lên Docker Hub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKER_HUB_CREDENTIALS') {
                        docker.image("${IMAGE_NAME}:${env.BUILD_ID}").push()
                    }
                }
            }
        }
        stage('Deploy to Web Server') {
            steps {
                // SSH vào Web Server và chạy container với Docker
                sshPublisher(publishers: [
                    sshPublisherDesc(
                        configName: 'tabilo-web',
                        transfers: [],
                        execCommand: '''
                            docker pull ${IMAGE_NAME}:${env.BUILD_ID}
                            docker stop something-server || true
                            docker rm something-server || true
                            docker run -d --name something-server -p 8080:8080 ${IMAGE_NAME}:${env.BUILD_ID}
                        ''',
                        usePromotionTimestamp: false, 
                        useWorkspaceInPromotion: false, 
                        verbose: true
                    )
                ])
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}

