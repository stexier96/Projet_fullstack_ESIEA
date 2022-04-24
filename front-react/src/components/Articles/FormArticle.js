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
                Article Title:  
                <input name="name" type="text" placeholder="title" onChange={this.handleChange}/>
            </p>
            <p>
                Author:  
                <input name="author" type="text" placeholder="name" onChange={this.handleChange}/>
            </p>
            <p>
                Article's content:  
                <input name="content" type="text" placeholder="Lorem Ipsum" onChange={this.handleChange}/>
            </p>
            <br/>
            <button onClick={this.setArticle}>
                Submit article
            </button>

        </div>
    }
}

export default FormArticle