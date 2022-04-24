import React from 'react'

import "./FormCategory.css"

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
        .then(res => res.json())
        .then(res => this.props.refreshCategories(res))
    }

    render() {
        return <div className='FormCategory'>
            Ajouter une catégorie
            <br/>
            <p>
                Nom : <input name="name" type="text" placeholder="Nom de la catégorie" onChange={this.handleChange}/>
            </p>
            <br/>
            <button onClick={this.setCategory}>
                Enregistrer
            </button>

        </div>
    }
}

export default FormCategories