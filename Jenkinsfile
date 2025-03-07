pipeline {
    agent any

    environment {
        PATH = "$PATH:/opt/homebrew/bin/mvn" // Ensure Maven is accessible
    }

    tools {
        maven 'maven3'  // Ensure Maven is configured in Jenkins -> Global Tool Configuration
    }

    stages {
        stage('Checkout Code') {
            steps {
                script {
                    try {
                        git branch: 'main', url: 'https://github.com/notshaangoswami/journal-app-backened.git'
                    } catch (Exception e) {
                        error "Git checkout failed: ${e.message}"
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    try {
                        sh 'echo $PATH'
                        sh 'mvn --version'
                        sh 'mvn clean package'
                    } catch (Exception e) {
                        error "Build failed: ${e.message}"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    try {
                        sh 'mvn test'
                    } catch (Exception e) {
                        error "Tests failed: ${e.message}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying Application...'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! ✅'
        }
        failure {
            echo 'Pipeline failed. ❌ Check logs for errors.'
        }
    }
}
