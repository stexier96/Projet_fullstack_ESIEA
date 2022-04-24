import React from 'react'
import moment from "moment";

import "./FormArticle.css"

class FormArticle extends React.Component {
    state = {
        articleID: "1",
        name: "",
        author: "",
        content: "",
        date: moment().format("YYYY-MM-DD"),
        category: {
            categoryId: "",
            name: ""
        }
    };

    handleChange = (event) => {
        this.setState({ [event.target.name]: event.target.value});
    }

    setArticle = () => {
        this.setState(prevState => {
            let category = Object.assign({}, prevState.category);
            category.categoryId = this.props.category.categoryId;
            return { category };
        })
        fetch("http://localhost:8080/api/private/article", {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
                },
            body: JSON.stringify({
            name: this.state.name,
            author: this.state.author,
            content: this.state.content,
            date: this.state.date,
            category: this.props.category,
            })
        })
        .then(res => res.json())
        .then(res => this.props.refreshArticles(res))
    }

    render() {
        return <div className='formArticle'>
            Ajouter un article
            <br/>
            <p>
                Titre de l'article:  
                <input name="name" type="text" placeholder="Titre" onChange={this.handleChange}/>
            </p>
            <p>
                Nom de l'autheur:  
                <input name="author" type="text" placeholder="Nom" onChange={this.handleChange}/>
            </p>
            <p>
                Contenu de l'article:  
                <input name="content" type="text" placeholder="Contenu" onChange={this.handleChange}/>
            </p>
            <button onClick={this.setArticle}>
                Enregistrer l'article
            </button>

        </div>
    }
}

export default FormArticle