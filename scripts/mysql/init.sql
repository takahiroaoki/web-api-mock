# change database
USE webapimock;

# initialize tables
DROP TABLE IF EXISTS mocks;

# 'mocks' table
CREATE TABLE mocks (
    mock_name VARCHAR(100) NOT NULL,
    mock_path VARCHAR(100) NOT NULL,
    status_code INT(3) NOT NULL,
    content_type VARCHAR(16) NOT NULL,
    response_body VARCHAR(5000),
    PRIMARY KEY(mock_path)
);
INSERT INTO mocks (
    mock_name,
    mock_path,
    status_code,
    content_type,
    response_body
) VALUES (
    "Sample Mock",
    '/sample',
    200,
    'application/json',
    '{"sample":"This is a sample mock which is initially registered."}'
);