properties([pipelineTriggers([githubPush()])])
 
pipeline {
    agent any
 
    stages {
        /* checkout repo */
        stage('Stage 1') {
            steps {
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
