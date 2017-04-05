### Vagrant 
Vagrant configuration is present to help bootstrap development process.
It runs Ubuntu and has development tools (like Java, Docker and etc.) installed during provision phase using Ansible.
To start Vagrant virtual machine, you need to have Vagrant installed on your computer (additionally vagrant-cachier plugin is recommended).

Then you can simply run:
```bash
vagrant up dev
```

Upon first run it will automatically provision the environment with Ansible.

SSH connection to the virtual machine can be made with the following command

```bash
vagrant ssh dev
```