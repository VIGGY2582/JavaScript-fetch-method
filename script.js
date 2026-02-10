fetch("http://localhost:8080/items/ui")

.then(function (response)
{
    return response.json()
})

.then(function(data)
{
    console.log(data)
})

.catch(function(error)
{
    console.log("Error occured")
})

console.log("console msg");