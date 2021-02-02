module.exports = {
  devServer: {
    port: 7300,
  },
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.css$/,
          use: ["postcss-loader"],
        },
      ],
    },
  },
};
