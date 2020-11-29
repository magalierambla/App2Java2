properties([pipelineTriggers([githubPush()])])
 
pipeline {
    agent any
 
    stages {
        /* checkout repo */
        stage('Build image') {
            steps {
             sh 'ls -l'
               sh 'docker images'
            }
        }
         stage('Stage 2') {
            steps {
               sh 'pwd'
            }
        }
    }
}
