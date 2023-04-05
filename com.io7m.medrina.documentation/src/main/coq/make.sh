#!/bin/sh -ex

coqc -Q Medrina Medrina Medrina/Names.v
coqc -Q Medrina Medrina Medrina/Attributes.v
coqc -Q Medrina Medrina Medrina/Roles.v
coqc -Q Medrina Medrina Medrina/Subjects.v
coqc -Q Medrina Medrina Medrina/Objects.v
coqc -Q Medrina Medrina Medrina/Actions.v
coqc -Q Medrina Medrina Medrina/Matches.v

mkdir -p html

coqdoc -Q Medrina Medrina --toc --utf8 -d html Medrina/*.v
