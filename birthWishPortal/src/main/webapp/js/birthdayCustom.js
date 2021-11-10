async function birthdayUpdate(emp_id) {

	let html = '';
	let updatename='';
	//let emp_id = document.getElementById("emp_id").value;
	
	console.log("emp_id" +emp_id);
	
	let rdata = {
		"emp_id" : emp_id
	};
	console.log("requested data"+rdata);
	let query = new URLSearchParams(rdata);

	await fetch('updateEmployeeServlet?action=1', 
	      { 
		  method: 'post',
		  body: query
          }).then(resp => { return resp.json() })
           .then(data => {
		
		let pro = data.empdata;
		console.log(...pro);
		console.log("data retured");
		
		pro.forEach(name => {
			
            document.getElementById("name").value = name.ename;
            document.getElementById("bdate").value = name.date_of_birth;
            document.getElementById("designation").value = name.designation;
            document.getElementById("message").value = name.message;
            document.getElementById("email").value = name.to_mail;
            document.getElementById("uploadfile").value = name.image_url;
									
		});
		service.insertAdjacentHTML('afterbegin', html);

	}).catch(erorr => console.log(erorr));
}


async function festivalUpdate(fest_id) {

	let html = '';
	let updatename='';
	//let emp_id = document.getElementById("emp_id").value;
	
	console.log("fest_id" +fest_id);
	
	let rdata = {
		"fest_id" : fest_id
	};
	console.log("requested data"+rdata);
	let query = new URLSearchParams(rdata);

	await fetch('updateEmployeeServlet?action=1', 
	      { 
		  method: 'post',
		  body: query
          }).then(resp => { return resp.json() })
           .then(data => {
		
		let pro = data.festdata;
		console.log(...pro);
		console.log("data retured");
		
		pro.forEach(name => {
			
            document.getElementById("name").value = name.ename;
            document.getElementById("bdate").value = name.date_of_birth;
            document.getElementById("designation").value = name.designation;
            document.getElementById("message").value = name.message;
            document.getElementById("email").value = name.to_mail;
            document.getElementById("uploadfile").value = name.image_url;
									
		});
		service.insertAdjacentHTML('afterbegin', html);

	}).catch(erorr => console.log(erorr));
}



