properties([pipelineTriggers([githubPush()])])
 
pipeline {
    agent any
 
    stages {
        /* checkout repo */
        stage('Stage 1') {
            steps {
               sh 'ls -l'
            }
        }
         stage('Stage 2') {
            steps {
               sh 'pwd'
            }
        }
    }
}
