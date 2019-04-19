// vars/verifyKnownHosts.groovy

def call(String host) {
    sh """
        ssh-keygen -R ${host}
        ssh-keyscan -H ${host} >> ~/.ssh/known_hosts 
    """
}
