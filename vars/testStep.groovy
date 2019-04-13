// vars/MyCustomStep.groovy

def call(String someVar = 'defValue') {
    echo "sample code ${someVar}"
    sh """
      ls -l 
    """
}

