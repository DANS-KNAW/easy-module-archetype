#!/usr/bin/env bash

PLAYBOOK=src/main/ansible/rebuild-repo.yml
INVENTORY=.vagrant/provisioners/ansible/inventory/vagrant_ansible_inventory
export ANSIBLE_CONFIG=`pwd`/src/main/ansible/ansible.cfg

echo "Using config in $ANSIBLE_CONFIG"
ansible-playbook $PLAYBOOK -i $INVENTORY
