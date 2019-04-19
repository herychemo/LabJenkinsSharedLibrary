// vars/sshCmd.groovy

def call(String cmd, String host, String user = '', String sshCredentials = '') {
    if (!cmd?.trim()) {
        error "No command provided."
        return
    }
    if (!host?.trim()) {
        error "No host provided."
        return
    }
    user = (!user?.trim())? '': "${user.trim()}@"

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
