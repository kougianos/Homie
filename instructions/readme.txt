#
#			 Install java 8
#
# url: https://tecadmin.net/install-oracle-java-8-ubuntu-via-ppa/

sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer


#
#			Netbeans full edition (EE)
#
# 		Important:  install tomcat from installation wizard
#		Write down directory of tomcat

# url: https://netbeans.org/downloads/
chmod +x netbeans-8.2-linux.sh

add : "netbeans_jdkhome="/usr/lib/jvm/java-8-oracle" to "/home/valia/netbeans-8.2/etc/netbeans.conf"


#
#			Tomcat
#
from netbeans wizard

#
#			 MySQL
#



#
#			 MySQL Workbench
#
from software center





