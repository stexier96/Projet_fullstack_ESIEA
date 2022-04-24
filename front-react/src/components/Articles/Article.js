import React from "react";

import "./Article.css"

const Article = ({ article }) => {
    return (
        <div className="article">
            <h4 className="title">{article.name} - {article.author} - {article.date}</h4>
            <p className="content">{article.content}</p>
        </div>
    )
}

export default Article;