pipeline {
    agent any

    tools {
        maven 'Maven3'  // Name as per Jenkins tool config
        jdk 'JDK11'     // Name as per Jenkins tool config
    }

    environment {
        GIT_URL = 'https://github.com/PramodTestHub/SeleniumAutomation.git'
        GIT_BRANCH = 'main'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: "${env.GIT_BRANCH}", url: "${env.GIT_URL}"
            }
        }

        stage('Build & Run Tests') {
            steps {
                echo 'Running Selenium-Cucumber Tests...'
                bat 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo 'Generating Allure Report...'
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            echo 'Archiving Test Results...'
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
        failure {
            echo 'Build Failed! Sending email notification...'
            // Uncomment if you configure email
              mail to: 'pramodhmh26@mail.com',
                  subject: "Jenkins Pipeline Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                  body: "Check Jenkins for details: ${env.BUILD_URL}"
        }
    }
}
