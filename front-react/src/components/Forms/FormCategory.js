import React from 'react'

class FormCategories extends React.Component {
    state = {
        name: "",
        categoryId: ""
    };

    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value});
    }

    setCategory = () => {
        fetch("http://localhost:8080/api/private/category", {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
                },
            body: JSON.stringify({
            name: this.state.name
            })
        })
        console.log("logtest",this.state)
    }

    render() {
        return <div>
            Ajouter une catégorie
            <br/>
            CategoryName : {this.state.name}
            <p>
                <input name="name" type="text" placeholder="Write your category here" onChange={this.handleChange}/>
            </p>
            <br/>
            <button onClick={this.setCategory}>
                Create Category
            </button>

        </div>
    }
}

export default FormCategories