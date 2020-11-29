properties([pipelineTriggers([githubPush()])])
 
pipeline {
    agent any
 
    stages {
     
        stage('Take down front-end and api') {
            steps {
             sh 'docker-compose -f ../App2Angular2/docker-compose.yml down'
            }
        }
         stage('Run Api service and Frontend application') {
            steps {
               sh 'docker-compose -f ../App2Angular2/docker-compose.yml up --build -d'
            }
        }
    }
}
