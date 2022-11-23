import React from "react";
import axios from "axios";

import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
 import { CardActionArea } from '@mui/material';

export default class UserPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: localStorage.getItem("user"),
            loggedIn : localStorage.getItem("logged"),
            role: localStorage.getItem("role"),
            serverName: "",
            serverEmail: "",
        }
    }

    componentDidMount() {
        let link = "http://localhost:8080/user/" + this.state.username;
        axios.get(link)
        .then(res => {
            this.setState({
                serverName: res.data.username,
                serverEmail: res.data.email,
                role: res.data.authorities[0].authority.replace("ROLE_", "")
            })
            //alert('../static/img/' + this.state.name + '.jpg')
        })
        .catch(err => {
            alert(err);
        });
    }

    render() {
        return (
           // <h1>{this.state.serverName + " " + this.state.serverEmail + " " + this.state.role}</h1>
           <> 
              <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="180"
          image="https://thumbs.dreamstime.com/b/default-avatar-profile-image-vector-social-media-user-icon-potrait-182347582.jpg"
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
          <h1> UserName : {this.state.serverName}</h1>
          </Typography>
          <Typography variant="body2" color="text.secondary">
          <h1> Email  : {this.state.serverEmail}</h1>
           <h1> Role : {this.state.role}</h1>
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
          
           
           </>
        )
    }
}