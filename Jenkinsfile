pipeline {
    agent any

   environment {
        GIT_URL = 'https://github.com/PramodTestHub/SeleniumAutomation.git'
        GIT_BRANCH = 'main'
        JAVA_HOME = "C:/Program Files/Java/jdk-21"
        MAVEN_HOME = "C:/Users/admin/Downloads/apache-maven-3.9.11-bin/apache-maven-3.9.11"
        PATH = "${JAVA_HOME}/bin;${MAVEN_HOME}/bin;${env.PATH}"
    }
    triggers {
        cron('H/5 * * * *')   
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
                bat "mvn clean test -Dsurefire.useFile=false"
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    commandline: 'allure',   // 👈 must match the name you set in Tools config
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }

    post {
        always {
            echo 'Archiving Test Results...'
            archiveArtifacts artifacts: 'allure-results/**', fingerprint: true
        }
        failure {
            echo 'Build Failed!'
        }
    }
}
