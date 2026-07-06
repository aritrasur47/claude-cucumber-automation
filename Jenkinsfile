pipeline {
    agent any

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'safari', 'edge'], description: 'Browser to run the suite against')
        string(name: 'CUCUMBER_TAGS', defaultValue: '(@PlaceOrder or @SearchProduct) and not @KnownFailure', description: 'Cucumber tag expression to filter scenarios')
    }

    environment {
        PATH = "/opt/homebrew/bin:/opt/homebrew/opt/openjdk@21/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Configure Browser') {
            steps {
                sh '''
                    sed -i '' "s/^browser=.*/browser=${BROWSER}/" src/test/resources/global.properties
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                    mvn -B test -Dtest=TestNGTestRunner \
                        -Dcucumber.filter.tags="${CUCUMBER_TAGS}"
                '''
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true
            archiveArtifacts artifacts: 'target/surefire-reports/**, target/allure-results/**', allowEmptyArchive: true
        }
    }
}
