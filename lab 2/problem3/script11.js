const app = document.getElementById('main') // access to the html div which has the id main


// Create a request variable and assign a new XMLHttpRequest object to it.
var request = new XMLHttpRequest()     

// the line below helps opening a new connection, using the GET request on the URL endpoint
request.open('GET', 'https://api.nasa.gov/planetary/apod?api_key=fLZPdkHJpu4sA6Xs6c3tLJcJax9hQ1s3Lx7QiWjp', true)

request.onload = function () {        // start accessing JSON data here
  var data = JSON.parse(this.response)
  if (request.status >= 200 && request.status < 400) {
 
      const h1 = document.createElement('h1')
      h1.textContent = data.title

      const p = document.createElement('p')
            p.textContent = `${data.explanation}`

      app.appendChild(h1)
      app.appendChild(p)

      if(data.media_type === 'video'){ 
         const frame = document.createElement('iframe')
         frame.setAttribute("height","400"); 
         frame.setAttribute("width","700")
         frame.src =data.url

         app.appendChild(frame)

      }
      else{
        const picture = document.createElement('img')
        picture.src =data.url
        app.appendChild(picture)
      }
} else {
    const errorMessage = document.createElement('marquee')
    errorMessage.textContent = `It does not work well, review your code or your API link`
    app.appendChild(errorMessage)
  }
}

request.send() // sending of the request
