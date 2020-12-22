
Vagrant.configure("2") do |config|
    config.vm.box = "hashicorp/bionic64"
	
  config.vm.provision "file", source: "demo", destination: ""
  config.vm.provision :shell, path: "docker.sh"
config.vm.provider :virtualbox do |vb|
  vb.gui = true
end
end