fetch("https://jsonplaceholder.typicode.com/users")

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