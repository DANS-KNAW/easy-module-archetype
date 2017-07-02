#!/usr/bin/env bash

${symbol_pound}include <service.sh>

MODULE_NAME=${artifactId}
PHASE="POST-TRANS"

echo "${symbol_dollar}PHASE: START"
service_restart ${symbol_dollar}MODULE_NAME
echo "${symbol_dollar}PHASE: DONE"
