# change database
USE webapimock;

# initialize tables
DROP TABLE IF EXISTS mocks;

# 'mocks' table
CREATE TABLE mocks (
    mock_path VARCHAR(100) NOT NULL,
    status_code INT(3) NOT NULL,
    content_type VARCHAR(16) NOT NULL,
    response_body VARCHAR(5000),
    PRIMARY KEY(mock_path)
);
INSERT INTO mocks (
    mock_path,
    status_code,
    content_type,
    response_body
) VALUES (
    '/test/greeting',
    200,
    'application/json',
    '{"greeting":"Hello, world!"}'
);