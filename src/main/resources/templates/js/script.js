const deleteButtons = document.querySelectorAll(".material-icons");

deleteButtons.forEach(button => {
   button.addEventListener("onclick", event => {
       const targetEvent = event.target;
       console.log(targetEvent);
   })
});