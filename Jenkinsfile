pipeline{

  stages {
    stage('git checkout'){
      steps{
        deleteDir()
        sh 'git clone https://github.com/magalierambla/App2Java2.git'
        sh 'git checkout master'
      }
    }
  }
}
