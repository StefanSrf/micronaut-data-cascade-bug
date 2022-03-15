--changeset demo:1 context:prod
CREATE TABLE parent
(
    id   INTEGER      NOT NULL,
    name VARCHAR(250) NOT NULL,
    CONSTRAINT pk_parent_id PRIMARY KEY (id)
);

CREATE TABLE child
(
    id        INTEGER      NOT NULL,
    name      VARCHAR(250) NOT NULL,
    parent_id INTEGER      NOT NULL,
    CONSTRAINT pk_child_id PRIMARY KEY (id)
);
