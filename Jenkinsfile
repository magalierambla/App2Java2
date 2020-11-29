properties([pipelineTriggers([githubPush()])])
 
pipeline {
    agent any
 
    stages {
     
        stage('Take down front-end and api') {
            steps {
             sh 'docker-compose down'
            }
        }
         stage('Run Api service and Frontend application') {
            steps {
               sh 'docker-compose up --build -d'
            }
        }
    }
}
