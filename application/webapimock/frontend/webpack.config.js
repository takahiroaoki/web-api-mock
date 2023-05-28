const MiniCssExtractPlugin = require("mini-css-extract-plugin");

module.exports = {
    entry: './src/list/index.js',
    output: {
        path: '/webapimock/src/main/resources/static/list',
        filename: 'index.js',
    },
    module: {
        rules: [
            {
                test: /\.(scss|sass|css)$/i,
                use: [MiniCssExtractPlugin.loader, 'css-loader', 'sass-loader'],
            },
        ],
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: 'index.css',
        }),
    ],
    watchOptions: {
        ignored: /node_modules/
    },
}