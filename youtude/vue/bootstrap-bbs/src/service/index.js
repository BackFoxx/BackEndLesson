import axios from "axios";

export const addContent = ({ user_id, title, context }) => {
  return axios.post("http://localhost:8081/add/content", {
    user_id,
    title,
    context
  });
};

export const modifyContent = ({ context_id, title, context }) => {
  return axios.post("http://localhost:8081/modify/content", {
    context_id,
    title,
    context
  });
};

export const deleteContent = ({ content_id }) => {
  return axios.post("http://localhost:8081/delete/content", {
    content_id
  });
};

export const findContent = ({ content_id }) => {
  return axios.get("http://localhost:8081/find/content", {
    params: { content_id }
  });
};

export const findContentList = () => {
  return axios.get("http://localhost:8081/find/content_list");
};

export const addComment = ({user_id, content_id, context}) => {
  return axios.post("http://localhost:8081/add/comment", {
    user_id, content_id, context
  })
}

export const addSubComment = ({user_id, comment_id, context}) => {
  return axios.post("http://localhost:8081/add/sub_comment", {
    user_id, comment_id, context
  })
}

export const findComment = ({ content_id }) => {
  return axios.get("http://localhost:8081/find/comment", {
    params: { content_id }
  });
};

export const findSubComment = ({ comment_id }) => {
  return axios.get("http://localhost:8081/find/sub_comment", {
    params: { comment_id }
  });
};

export const findUser = ({ user_id }) => {
  return axios.get("http://localhost:8081/find/user", {
    params: { user_id }
  });
};
