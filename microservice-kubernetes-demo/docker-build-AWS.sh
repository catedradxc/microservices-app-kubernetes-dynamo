#!/bin/sh

docker build --tag=microservice-kubernetes-persistence-apache apache
docker tag microservice-kubernetes-persistence-apache 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:apache
docker push 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:apache

docker build --tag=microservice-kubernetes-persistence-catalog microservice-kubernetes-demo-catalog
docker tag microservice-kubernetes-persistence-catalog 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:catalog
docker push 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:catalog

docker build --tag=microservice-kubernetes-demo-customer microservice-kubernetes-demo-customer
docker tag microservice-kubernetes-demo-customer 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:customer
docker push 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:customer

docker build --tag=microservice-kubernetes-demo-order microservice-kubernetes-demo-order
docker tag microservice-kubernetes-demo-order 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:order
docker push 608842968837.dkr.ecr.eu-central-1.amazonaws.com/eks-persistence-layer:order