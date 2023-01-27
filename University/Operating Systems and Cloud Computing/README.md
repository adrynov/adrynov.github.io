Open an SSH client.

Locate your private key file. The key used to launch this instance is Web Server Key.pem

Run this command, if necessary, to ensure your key is not publicly viewable.

chmod 400 Web Server Key.pem

Connect to your instance using its Public DNS: ec2-54-164-167-75.compute-1.amazonaws.com

Example:

`ssh -i "Web Server Key.pem" ubuntu@ec2-54-164-167-75.compute-1.amazonaws.com`
