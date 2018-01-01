#!/usr/bin/env bash

echo "Enter Vkontakte application ID"
read vkAppId

echo "Go to Vkontakte and generate your personal token."
echo "WARNING! Don't share your token!! You can lost access to your page!!"
vkGenerateTokenUrl="https://oauth.vk.com/authorize?client_id=$vkAppId&display=page&scope=offline,friends,groups,messages&response_type=token&v=5.62&state=123456"

if which xdg-open > /dev/null
then
  xdg-open "$vkGenerateTokenUrl" > /dev/null 2>&1
elif which gnome-open > /dev/null
then
  gnome-open "$vkGenerateTokenUrl" > /dev/null 2>&1
fi

echo "Now enter you token"
read token

echo "HOTEL_HERO__VKONTAKTE_TOKEN=$token" | sudo tee --append /etc/profile
echo 'export HOTEL_HERO__VKONTAKTE_TOKEN' | sudo tee --append /etc/profile

source /etc/profile


export DREBEDENGI__WSDL_LOCATION="http://www.drebedengi.ru/soap/?wsdl"
export DREBEDENGI__APP_ID="demo_api"
export DREBEDENGI__LOGIN="demo@example.com"
export DREBEDENGI__PASSWORD="demo"