pipeline{
agent any

  stages {
    stage('first step'){
      steps{
        sh 'docker ps'
        sh 'docker images'
        sh 'docker build -t app2java2 .'
        sh 'docker images'
      }
    }
  }
}
