docker build . -t fileUploadApp -f dockerFile
docker run -p 8080:8080 -p 28787:28787 --name fileUploadApp --restart unless-stopped -d fileUploadApp