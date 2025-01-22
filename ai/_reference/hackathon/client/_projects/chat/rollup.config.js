import svelte from 'rollup-plugin-svelte';
import commonjs from '@rollup/plugin-commonjs';
import resolve from '@rollup/plugin-node-resolve';
import sveltePreprocess from 'svelte-preprocess';
import typescript from '@rollup/plugin-typescript';
import css from "rollup-plugin-import-css";
import json from '@rollup/plugin-json';
import {config} from 'dotenv';
import replace from '@rollup/plugin-replace';

const production = !process.env.ROLLUP_WATCH;

export default {
    input: './src/index.ts',
    output: {
        format: 'iife',
        file: './build/bundle.js',
        name: 'app',
        sourcemap: true,
    },
    plugins: [
        replace(
            {
                include: [
                    'src/**/*.svelte',
                    'src/**/*.ts',
                    'src/**/*.png',
                ],
                preventAssignment: true,
                environment: () => JSON.stringify(config().parsed),
            }
        ), 
        svelte(
            {
                preprocess: sveltePreprocess(
                    {
                        postcss: true
                    }
                )
            }
        ),
        resolve({ browser: true }),
        commonjs(),
        typescript(),
        css({ output: 'bundle.css' }),
        json()
    ],
};