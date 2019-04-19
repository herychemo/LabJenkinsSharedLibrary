// vars/sshCmd.groovy

def call(String cmd, String host, String user = '', String sshCredentials = '') {
    if (!cmd) {
        error "No command provided."
        return
    }
    if (!host) {
        error "No command provided."
        return
    }
    user = (!user)? '': "${user}@"

    def finalCmd = "ssh ${user}${host} ${cmd}"
    def response = ''

    verifyKnownHosts host

    if (sshCredentials) {
        sshagent(credentials: [sshCredentials], ignoreMissing: false) {
            response = sh script : finalCmd, returnStdout: true
        }
    }else {
        response = sh script : finalCmd, returnStdout: true
    }

    return response
}
