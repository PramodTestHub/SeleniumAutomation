pipeline {
    agent any

   environment {
        GIT_URL = 'https://github.com/PramodTestHub/SeleniumAutomation.git'
        GIT_BRANCH = 'main'
        JAVA_HOME = "C:/Program Files/Java/jdk-21"
        MAVEN_HOME = "C:/Users/admin/Downloads/apache-maven-3.9.11-bin/apache-maven-3.9.11"
        PATH = "${JAVA_HOME}/bin;${MAVEN_HOME}/bin;${env.PATH}"
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
                bat "mvn -version"
                bat "mvn clean test"
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo 'Generating Allure Report...'
               // allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            echo 'Archiving Test Results...'
            archiveArtifacts artifacts: '**/target/*.log', allowEmptyArchive: true
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
