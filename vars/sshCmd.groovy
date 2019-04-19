// vars/sshCmd.groovy

def call(String cmd, String host, String user = '', String sshCredentials = '', isContainer = false, port = 22) {
    if (!cmd?.trim()) {
        error "No command provided."
        return
    }
    if (!host?.trim()) {
        error "No host provided."
        return
    }
    if (isContainer) {
        host = getContainerIp(host)
    }
    cmd = cmd.trim()
    host = host.trim()
    user = (!user?.trim())? '': "${user.trim()}@"
    port = (port)? port : 22

    def finalCmd = "ssh -p ${port} ${user}${host} ${cmd}"

    verifyKnownHosts host

    def response = ''
    if (sshCredentials) {
        sshagent(credentials: [sshCredentials], ignoreMissing: false) {
            response = sh script : finalCmd, returnStdout: true
        }
    }else {
        response = sh script : finalCmd, returnStdout: true
    }

    return response
}
