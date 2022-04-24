import React from 'react'
import moment from "moment";

class FormArticles extends React.Component {
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
            //category: this.state.category,
            })
        })
        console.log("logtest",this.state)
    }

    render() {
        return <div>
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

export default FormArticles