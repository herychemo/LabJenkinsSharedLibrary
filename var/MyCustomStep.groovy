#!/usr/bin/env groovy
// vars/MyCustomStep.groovy

def call() {
    echo "sample code"
    sh """
      ls -l 
    """
}

