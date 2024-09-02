async function uploadFile() {

    const email = document.getElementById("email").value;
    const file1 = document.getElementById("file1").files[0];

    const data = new FormData();

    data.append("email", email);
    data.append("file", file1);

    const response = await fetch(
            "Uploading",
            {
                method: "POST",
                body: data,
            }

    );

    if (response.ok) {
        console.log("Success");
    } else {
        console.log("Error");

    }
}
